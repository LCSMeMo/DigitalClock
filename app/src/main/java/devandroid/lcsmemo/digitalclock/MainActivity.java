package devandroid.lcsmemo.digitalclock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textAppName, textHoraAtual;
    TextClock textHora;
    Button btnAtualizarHora;

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
        iniciarComponentesDoLayout();
        capturarHoraAtual();
    }

    private void capturarHoraAtual() {
        btnAtualizarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textHoraAtual.setText("Hora atual: "+textHora.getText());
            }
        });
    }

    private void iniciarComponentesDoLayout() {
        textAppName = findViewById(R.id.textAppName);
        textHoraAtual = findViewById(R.id.textHoraAtual);
        textHora = findViewById(R.id.textHora);
        btnAtualizarHora = findViewById(R.id.btnAtualizarHora);
    }
}