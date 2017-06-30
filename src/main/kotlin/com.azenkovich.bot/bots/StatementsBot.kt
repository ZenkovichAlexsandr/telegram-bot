package com.azenkovich.bot.bots

import org.telegram.telegrambots.api.methods.send.SendDocument
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import java.io.File

/**
 * @author alexsandr
 * @since 30.06.17.
 */
class StatementsBot(val bot: TelegramLongPollingBot) : Bot {
    val URL = "/Users/alexsandr/Documents/Проекты/TelegramBot/src/main/resources/statements/";

    val ALL_FILES: Array<String> = File(this.URL).list()

    override fun action(chatId: Long, message: String) {
        val files = this.getSuitableFiles(message)

        if (files.isEmpty()) {

            bot.sendMessage(SendMessage(chatId, "Не найдено документа с именем - ${message}"));
            return
        }
        val sendDoc = SendDocument().setChatId(chatId);

        files.forEach {
            bot.sendDocument(sendDoc.setNewDocument(File("${this.URL}$it")).setCaption(it))
        }
    }

    fun getSuitableFiles(name: String): List<String> {
        val result = ALL_FILES.filter { it.contains(name, true) }

        if (result.isEmpty() && name.length > 1) {
            return getSuitableFiles(name.dropLast(1))
        }
        return result
    }
}