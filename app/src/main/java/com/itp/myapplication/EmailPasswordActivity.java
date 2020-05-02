package com.itp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.itp.myapplication.databinding.ActivityEmailpasswordBinding;
import com.itp.myapplication.FirstPage;



public class EmailPasswordActivity extends AppCompatActivity implements View.OnClickListener {


        private static final String TAG = "EmailPassword";

        private ActivityEmailpasswordBinding mBinding;

        // [START declare_auth]
        private FirebaseAuth mAuth;
        // [END declare_auth]

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mBinding = ActivityEmailpasswordBinding.inflate(getLayoutInflater());
            setContentView(mBinding.getRoot());

            // Buttons

            mBinding.emailSignInButton.setOnClickListener((View.OnClickListener) this);
            mBinding.verifyEmailButton.setOnClickListener((View.OnClickListener) this);



            // [START initialize_auth]
            // Initialize Firebase Auth
            mAuth = FirebaseAuth.getInstance();
            // [END initialize_auth]
        }

        // [START on_start_check_user]
        @Override
        public void onStart() {
            super.onStart();
            // Check if user is signed in (non-null) and update UI accordingly.
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        }
        // [END on_start_check_user]








        private void signIn(String email, String password) {
            Log.d(TAG, "signIn:" + email);
            if (validateForm()) {
                return;
            }

final Intent firstPageIntent = new Intent(this, FirstPage.class);
            // [START sign_in_with_email]
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                                startActivity(firstPageIntent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                                //  [START_EXCLUDE]
                                // [END_EXCLUDE]
                            }

                            // [START_EXCLUDE]
                            if (!task.isSuccessful()) {
                                mBinding.status.setText(R.string.auth_failed);

                            }
                        }


                            // [END_EXCLUDE]
                    });

            // [END sign_in_with_email]

        }




        private void sendEmailVerification() {
            // Disable button
            mBinding.verifyEmailButton.setEnabled(false);

            // Send verification email
            // [START send_email_verification]
            final FirebaseUser user = mAuth.getCurrentUser();
            user.sendEmailVerification()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            // [START_EXCLUDE]
                            // Re-enable button
                            mBinding.verifyEmailButton.setEnabled(true);

                            if (task.isSuccessful()) {
                                Toast.makeText(EmailPasswordActivity.this,
                                        "Verification email sent to " + user.getEmail(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Log.e(TAG, "sendEmailVerification", task.getException());
                                Toast.makeText(EmailPasswordActivity.this,
                                        "Failed to send verification email.",
                                        Toast.LENGTH_SHORT).show();
                            }
                            // [END_EXCLUDE]
                        }
                    });
            // [END send_email_verification]


        }

        private void reload() {
            mAuth.getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        updateUI(mAuth.getCurrentUser());
                        Toast.makeText(EmailPasswordActivity.this,
                                "Reload successful!",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e(TAG, "reload", task.getException());
                        Toast.makeText(EmailPasswordActivity.this,
                                "Failed to reload user.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        private boolean validateForm() {
            boolean valid = true;

            String email = mBinding.fieldEmail.getText().toString();
            if (TextUtils.isEmpty(email)) {
                mBinding.fieldEmail.setError("Required.");
                valid = false;
            } else {
                mBinding.fieldEmail.setError(null);
            }

            String password = mBinding.fieldPassword.getText().toString();
            if (TextUtils.isEmpty(password)) {
                mBinding.fieldPassword.setError("Required.");
                valid = false;
            } else {
                mBinding.fieldPassword.setError(null);
            }

            return !valid;
        }

        private void updateUI(FirebaseUser user) {

            if (user != null) {
                mBinding.status.setText(getString(R.string.emailpassword_status_fmt,
                        user.getEmail(), user.isEmailVerified()));
               // mBinding.detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));

                mBinding.emailPasswordButtons.setVisibility(View.GONE);
                mBinding.emailPasswordFields.setVisibility(View.GONE);
                mBinding.signedInButtons.setVisibility(View.VISIBLE);

                if (user.isEmailVerified()) {
                    mBinding.verifyEmailButton.setVisibility(View.GONE);
                } else {
                    mBinding.verifyEmailButton.setVisibility(View.VISIBLE);
                }
            } else {
                mBinding.status.setText(R.string.signed_out);
               // mBinding.detail.setText(null);

                mBinding.emailPasswordButtons.setVisibility(View.VISIBLE);
                mBinding.emailPasswordFields.setVisibility(View.VISIBLE);
                mBinding.signedInButtons.setVisibility(View.GONE);
            }

        }




@Override
        public void onClick(View v) {
            int i = v.getId();
            if (i == R.id.emailSignInButton) {
                signIn(mBinding.fieldEmail.getText().toString(), mBinding.fieldPassword.getText().toString());

            } else if (i == R.id.verifyEmailButton) {
                sendEmailVerification();
            }
        }
    private void openFirstPage()
    {
        Intent intent = new Intent(this, FirstPage.class);
        startActivity(intent);
    }

}

