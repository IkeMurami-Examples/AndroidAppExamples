package ike.murami.example_koin_app

import android.app.Activity
import android.app.Application
import ike.murami.example_koin_app.logger.LoggerProvider
import java.util.logging.Logger




object Core {

    private lateinit var application: Application
    internal lateinit var deepLinkActivity: Class<out Activity>
        private set

    fun initialize(
        application: Application,
        deepLinkActivity: Class<out Activity>) {
        this.application = application
        this.deepLinkActivity = deepLinkActivity
    }

    private fun initializeAndroidPlatform() {
        val logger = LoggerProvider(application).getLogger()
    }

    private fun getKoinApp(logger: Logger) {}
}