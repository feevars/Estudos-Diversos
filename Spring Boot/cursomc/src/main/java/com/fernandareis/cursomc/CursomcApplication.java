package com.fernandareis.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fernandareis.cursomc.domain.Categoria;
import com.fernandareis.cursomc.domain.Cidade;
import com.fernandareis.cursomc.domain.Cliente;
import com.fernandareis.cursomc.domain.Endereco;
import com.fernandareis.cursomc.domain.Estado;
import com.fernandareis.cursomc.domain.Pagamento;
import com.fernandareis.cursomc.domain.PagamentoComBoleto;
import com.fernandareis.cursomc.domain.PagamentoComCartao;
import com.fernandareis.cursomc.domain.Pedido;
import com.fernandareis.cursomc.domain.Produto;
import com.fernandareis.cursomc.domain.enums.EstadoPagamento;
import com.fernandareis.cursomc.domain.enums.TipoCliente;
import com.fernandareis.cursomc.repositories.CategoriaRepository;
import com.fernandareis.cursomc.repositories.CidadeRepository;
import com.fernandareis.cursomc.repositories.ClienteRepository;
import com.fernandareis.cursomc.repositories.EnderecoRepository;
import com.fernandareis.cursomc.repositories.EstadoRepository;
import com.fernandareis.cursomc.repositories.PagamentoRepository;
import com.fernandareis.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Cliente cli1 = new Cliente(null, "Fernanda Reis", "fp.reis@live.com", "388859685-75", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("959698567", "1120473807"));
		
		Endereco e1 = new Endereco(null, "Rua Taioaba", "67", "casa", "Mooca", "03170-070", cli1, c3);
		Endereco e2 = new Endereco(null, "Avenida Clodoaldo Norberto Buchetti", "20", "casa", "Jardim Real", "01460-070", cli1, c3);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("20/01/2020 20:20"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("05/02/2020 14:23"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("21/01/2020 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		
	}

}
