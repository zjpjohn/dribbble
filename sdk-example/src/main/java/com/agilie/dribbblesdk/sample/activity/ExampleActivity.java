package com.agilie.dribbblesdk.sample.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.agilie.dribbblesdk.domain.Shot;
import com.agilie.dribbblesdk.sample.printable.PrintableShotsCallback;
import com.agilie.dribbblesdk.service.auth.AuthCredentials;
import com.agilie.dribbblesdk.service.auth.DribbbleAuthHelper;
import com.agilie.dribbblesdk.service.auth.DribbbleConstants;
import com.agilie.dribbblesdk.service.retrofit.DribbbleServiceGenerator;
import com.google.api.client.auth.oauth2.Credential;

import java.util.Arrays;
import java.util.List;

import agilie.dribbblesdkexample.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExampleActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_STATE_AUTH_TOKEN = "key_state_auth_token";

    private static final int NUMBER_OF_PAGES = 1;
    private static final int SHOTS_PER_PAGE = 5;

    private static final String DRIBBBLE_CLIENT_ID = "852df5ad94d39c83833f1fda6e809c05225ad9e422dc37a313b71c163572d3a6";
    private static final String DRIBBBLE_CLIENT_SECRET = "065fecc7c01a3df2aed9d2ef435721876493e6bdeb7ed04639452782396faeb8";
    private static final String DRIBBBLE_CLIENT_ACCESS_TOKEN = "a259d748440ffff52d0565b9a2879ea8fbeb8c7cb2a292e138659033d3319eff";
    private static final String DRIBBBLE_CLIENT_REDIRECT_URL = "http://www.tangshiba.com";

    private TextView mTextViewResponse;
    private ProgressBar mProgressBar;

    private String authToken;

    /* Activity Lifecycle */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        mTextViewResponse = (TextView) findViewById(R.id.example_textView_response);
        mProgressBar = (ProgressBar) findViewById(R.id.example_progressBar);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString(KEY_STATE_AUTH_TOKEN, authToken);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(KEY_STATE_AUTH_TOKEN)) {
            authToken = savedInstanceState.getString(KEY_STATE_AUTH_TOKEN);
        }
    }

    /* Menu */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem authMenuItem = menu.findItem(R.id.action_auth);
        authMenuItem.setTitle(isLoggedIn() ? R.string.action_bar_log_out : R.string.action_bar_log_in);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_auth: {
                if (isLoggedIn()) {
                    logout();
                } else {
                    login();
                }
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    /* OnClickListener */

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.example_button_get_my_shot:
                getMyShot();
                break;
            case R.id.example_button_get_recent_shot:
                getRecentShot();
                break;
            default:
                break;
        }
    }

    /* Network */

    private void getMyShot() {
        showProgressBar();
        Call<List<Shot>> shotsCall = DribbbleServiceGenerator
                .getDribbbleUserService(authToken)
                .getAuthenticatedUsersShots(NUMBER_OF_PAGES, SHOTS_PER_PAGE);
        shotsCall.enqueue(new Callback<List<Shot>>() {
            @Override
            public void onResponse(Response<List<Shot>> response) {
                response.body();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public void getRecentShot() {
        showProgressBar();
        Call<List<Shot>> shotsCall = DribbbleServiceGenerator
                .getDribbbleShotService(DRIBBBLE_CLIENT_ACCESS_TOKEN)
                .fetchShots(NUMBER_OF_PAGES, SHOTS_PER_PAGE);
        shotsCall.enqueue(new Callback<List<Shot>>() {
            @Override
            public void onResponse(Response<List<Shot>> response) {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    /* Auth */

    private void login() {
        final AuthCredentials credentials = AuthCredentials.newBuilder(
                DRIBBBLE_CLIENT_ID,
                DRIBBBLE_CLIENT_SECRET,
                DRIBBBLE_CLIENT_ACCESS_TOKEN,
                DRIBBBLE_CLIENT_REDIRECT_URL)
                .setScope(Arrays.asList(
                        DribbbleConstants.SCOPE_PUBLIC,
                        DribbbleConstants.SCOPE_WRITE,
                        DribbbleConstants.SCOPE_UPLOAD,
                        DribbbleConstants.SCOPE_COMMENT))
                .build();

        DribbbleAuthHelper.startOauthDialog(ExampleActivity.this, credentials, new DribbbleAuthHelper.AuthListener() {

            @Override
            public void onSuccess(final Credential credential) {
                authToken = credential.getAccessToken();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        invalidateOptionsMenu();
                        Toast.makeText(ExampleActivity.this, R.string.toast_logged_in, Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
                // TODO: handle error here
            }
        });
    }

    public void logout() {
        AuthCredentials credentials = AuthCredentials.newBuilder(
                DRIBBBLE_CLIENT_ID,
                DRIBBBLE_CLIENT_SECRET,
                DRIBBBLE_CLIENT_ACCESS_TOKEN,
                DRIBBBLE_CLIENT_REDIRECT_URL)
                .build();

        authToken = null;
        DribbbleAuthHelper.logout(this, credentials);
        Toast.makeText(ExampleActivity.this, R.string.toast_logged_out, Toast.LENGTH_LONG).show();
    }

    /* Private helpers */

    private boolean isLoggedIn() {
        return !TextUtils.isEmpty(authToken);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
        mTextViewResponse.setVisibility(View.GONE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
        mTextViewResponse.setVisibility(View.VISIBLE);
    }
}
