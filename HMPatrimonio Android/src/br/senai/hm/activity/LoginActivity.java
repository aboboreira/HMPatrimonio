package br.senai.hm.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.senai.hm.R;
import br.senai.hm.modelo.Permissao;
import br.senai.hm.modelo.Usuario;
import br.senai.hm.util.WebService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	private EditText login,senha;
	private List<Usuario> listaU;
	private Usuario usuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		login = (EditText) findViewById(R.id.et01);
		senha = (EditText) findViewById(R.id.et02);
		listaU = getUsuarioWS();
	}
	
	public void enviar(View v){
		if (login.getText().toString().isEmpty()) {
			Toast.makeText(this, R.string.aviso_nome, Toast.LENGTH_SHORT).show();
		}else if(senha.getText().toString().isEmpty()){
			Toast.makeText(this, R.string.aviso_senha, Toast.LENGTH_SHORT).show();
		}else if (validarUsuario(login.getText().toString(),senha.getText().toString())) {
			logar(usuario);	
		}else{
			Toast.makeText(this, R.string.aviso_logar, Toast.LENGTH_SHORT).show();
		}
	}
	
	public boolean validarUsuario(String login,String senha){
		List<Usuario> lista = new ArrayList<Usuario>(listaU);
		for (Usuario u : lista) {
			if (login.equals(u.getLogin()) && senha.equals(u.getSenha()) ) {
				usuario = u;
				return true;
			}
		}
		return false;
	}
	
	public List<Usuario> getUsuarioWS(){
		// cria String com URL completa
		String url = WebService.URL+"usuario/lista";
		//passar a url para o metodo makeRequest e obter a resposta
		String resposta = WebService.makeRequest(url);
		//cria uma instancia de Gson
		Gson gson = new Gson();
		//criar um tipo
		Type tipoLista = new TypeToken<List<Usuario>>(){}.getType();
		// Converte a resposta em lista de genero
		List<Usuario> listaCompleta = gson.fromJson(resposta, tipoLista);
		//retorna lista
		List<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario u : listaCompleta) {
			if (u.getPermissao() == Permissao.GESTOR && u.isStatus()) {
				lista.add(u);
			}
		}
		if (lista.isEmpty()) {
			Toast.makeText(this, R.string.lista_vazia, Toast.LENGTH_SHORT).show();
			return null;
		}
		return lista;
	}
	
	public void logar(Usuario u){
		Intent intent = new Intent(this,MainActivity.class);
		intent.putExtra("usuario", usuario);
		startActivity(intent);
		finish();
	}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
	}
}
