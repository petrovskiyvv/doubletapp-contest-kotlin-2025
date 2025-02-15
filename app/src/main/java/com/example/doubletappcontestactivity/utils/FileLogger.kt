import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.File
import java.io.IOException
import java.time.LocalDateTime

object FileLogger {
    @RequiresApi(Build.VERSION_CODES.O)
    fun log(context: Context, message: String) {
        try {
            val logFile = File(context.filesDir, "activity_lifecycle.log")
            logFile.appendText("${LocalDateTime.now()}: $message\n")
        } catch (e: IOException) {
            Log.e("FileLogger", "Error writing to log file", e)
        }
    }
}