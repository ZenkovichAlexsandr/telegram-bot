package com.azenkovich.bot

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi

/**
 * @author alexsandr
 * @since 30.06.17.
 */

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    TelegramBotsApi()
            .registerBot(MainBot())
}