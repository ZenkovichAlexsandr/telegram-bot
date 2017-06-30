package com.azenkovich.bot

/**
 * @author alexsandr
 * @since 30.06.17.
 */

val INIT_COMMAND = "/"

val HELP_COMMAND = "${INIT_COMMAND}help"
val STATEMENTS_COMMAND = "${INIT_COMMAND}statements"


val getCommands = {
    "Supported commands: \n" +
            "|-- ${HELP_COMMAND} : list of supported commands \n" +
            "|-- ${STATEMENTS_COMMAND} : find document \n"
}
