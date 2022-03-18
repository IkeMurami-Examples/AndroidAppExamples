package ike.murami.example_koin_app.logger

import android.app.Application
import java.util.logging.Logger

class LoggerProvider(private val application: Application) {

    private val logger = Logger.getLogger("MyLogger") as Logger

    fun getLogger(): Logger {
        return logger
    }

}