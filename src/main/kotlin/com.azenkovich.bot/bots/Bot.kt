package com.azenkovich.bot.bots

/**
 * @author alexsandr
 * @since 30.06.17.
 */
interface Bot {
    fun action(chatId: Long, message: String)
}