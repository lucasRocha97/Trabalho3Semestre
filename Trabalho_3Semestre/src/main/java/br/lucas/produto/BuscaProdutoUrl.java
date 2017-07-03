package br.lucas.produto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.lucas.db.ProdutoDao;

public class BuscaProdutoUrl {
	
	
	public List<Produto> lerProdutos(String strUrl) throws Exception{
		List<Produto> lista = new ArrayList<>();
		
		URL url = new URL("http://www.master10.com.py/lista-txt/download");
		URLConnection urlCon = url.openConnection(); //estabelece conexão com o site;
		
		try(InputStream is = urlCon.getInputStream();
				InputStreamReader isr = new InputStreamReader(is); //lê a estream, um caractere de cada vez;
				
				BufferedReader in = new BufferedReader(isr)){ //BufferReader carrega um pouco de cada vez (junta os caracteres);
															 //neste caso até formar uma linha;
			
			String linha;
			while((linha  = in.readLine()) != null){
				if(linha.matches("[0-9]+.*")){ //pesquizar expresão regular em java
					Produto p = lerProduto(linha);
					lista.add(p);
				}
			}
		}
		
		return lista;
	}
	
	private Pattern pattern = Pattern.compile("([0-9]+)(.*)US\\$ (.*)");

	private Produto lerProduto(String linha) {
		Matcher mat = pattern.matcher(linha);
		
		Produto produto = new Produto();
		
		if(mat.matches()){ //a linha combina com o padrão entra no if;
		
			String strId = mat.group(1).trim();
			produto.setId(Integer.parseInt(strId));
			
			String desc = mat.group(2).trim();
			produto.setDescricao(desc);
		
			String strValorOriginal = mat.group(3).trim();
			String strValorSemponto = strValorOriginal.replaceAll("\\.", "");
			String strValorIngles = strValorSemponto.replaceAll(",", ".");
			produto.setValor(new BigDecimal(strValorIngles)); //pesquizar replaceAll

		}else{
			throw new RuntimeException("Linha inválida: " + linha);
		}
		
		return produto;
	}
	
//	public static void main(String[] args) throws Exception {
//		String url = "";
//		BuscaProdutoUrl bp = new BuscaProdutoUrl();
//		List<Produto> lista = bp.lerProdutos(url);
//		lista.forEach((e) -> System.out.println(e.toString()));
//	}
	
}
