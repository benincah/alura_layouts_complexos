package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

import static br.com.alura.aluraviagens.ui.activity.ActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            inicialidaCampos(intent);
        }
    }

    private void inicialidaCampos(Intent intent) {
        Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
        mostraImagem(pacote);
        mostraLocal(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView precoPacote = findViewById(R.id.resumo_compra_preco_pacote);
        precoPacote.setText(MoedaUtil.formataMoedaParaBrasileiro(pacote.getPreco()));
    }

    private void mostraData(Pacote pacote) {
        TextView dataPacote = findViewById(R.id.resumo_compra_data_viagem);
        dataPacote.setText(DataUtil.periodoEmTexto(pacote.getDias()));
    }

    private void mostraLocal(Pacote pacote) {
        TextView localpacote = findViewById(R.id.resumo_compra__local_pacote);
        localpacote.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagemPacote = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawable = ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagemPacote.setImageDrawable(drawable);
    }
}