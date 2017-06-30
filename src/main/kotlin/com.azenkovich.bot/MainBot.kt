package com.azenkovich.bot

import com.azenkovich.bot.bots.StatementsBot
import com.azenkovich.bot.configurations.BOT_TOKEN
import com.azenkovich.bot.configurations.BOT_USERNAME
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import java.util.*

/**
 * @author alexsandr
 * @since 30.06.17.
 */
class MainBot : TelegramLongPollingBot() {

    val statementsBot = StatementsBot(this)

    override fun onUpdateReceived(update: Update) {
        val message = update.message

        if (Objects.isNull(message) || !message.hasText()) {
            return
        }

        val parts = message.text.split(" ".toRegex(), 2)

        when(parts[0]) {
            HELP_COMMAND ->
                sendMessage(SendMessage(message.chatId, getCommands()))
            STATEMENTS_COMMAND ->
                    statementsBot.action(message.chatId, parts[1])
            else ->
                    sendMessage(SendMessage(message.chatId, "Неизвестная комманда"))
        }
    }

    override fun getBotUsername(): String {
        return BOT_USERNAME
    }

    override fun getBotToken(): String {
        return BOT_TOKEN
    }
}