import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequestTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        // Kode permintaan HTTP di sini
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // Handle respons dari API di sini
    }
}
