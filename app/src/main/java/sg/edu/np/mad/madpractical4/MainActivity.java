package sg.edu.np.mad.madpractical4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String randomnum = getIntent().getStringExtra("randomnum");
        String randdesc = getIntent().getStringExtra("randdesc");
        boolean randfollow = getIntent().getBooleanExtra("randfollow",false);

        User user    = new User(randomnum, randdesc, 1, randfollow);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnfollow = findViewById(R.id.btnfollow);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        if (user.isFollowed() == true) {
            btnfollow.setText("Unfollow");
        }
        else {
            btnfollow.setText("Follow");
        }

        btnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed() == true) {
                    user.followed = false;
                    btnfollow.setText("Follow");
                }
                else{
                    user.followed = true;
                    btnfollow.setText("Unfollow");
                }
            }
        });

    }
}