package com.fernandareis.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernandareis.cursomc.domain.Categoria;
import com.fernandareis.cursomc.domain.Cidade;
import com.fernandareis.cursomc.domain.Estado;
import com.fernandareis.cursomc.domain.Produto;
import com.fernandareis.cursomc.repositories.CategoriaRepository;
import com.fernandareis.cursomc.repositories.CidadeRepository;
import com.fernandareis.cursomc.repositories.EstadoRepository;
import com.fernandareis.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 500.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade (null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade (null, "Uberlândia", est1);
		Cidade c3 = new Cidade (null, "São Paulo", est2);
		Cidade c4 = new Cidade (null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2));
		
		est2.getCidades().addAll(Arrays.asList(c3));
		est2.getCidades().addAll(Arrays.asList(c4));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
	}

}
