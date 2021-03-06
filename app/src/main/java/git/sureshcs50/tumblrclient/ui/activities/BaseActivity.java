package git.sureshcs50.tumblrclient.ui.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.User;

import org.apache.http.client.UserTokenHandler;

import git.sureshcs50.tumblrclient.R;
import git.sureshcs50.tumblrclient.TumblrClientApplication;
import git.sureshcs50.tumblrclient.utils.Utils;

/**
 * Created by sureshkumar-pc on 18/01/2016.
 */
public class BaseActivity extends AppCompatActivity {

    private static User mUser;

    public JumblrClient getClient() {
        return TumblrClientApplication.getClient();
    }

    public User getUser(){return mUser;}

    public void setUser(User user){
        this.mUser = user;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!Utils.hasConnection(this)) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Network Failed!");
            alertDialog.setMessage(getString(R.string.msg_connection_failed));
            alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialog.show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}