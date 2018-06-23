package com.guttomarttins.modeloconceitual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guttomarttins.modeloconceitual.domain.Categoria;
import com.guttomarttins.modeloconceitual.domain.Cidade;
import com.guttomarttins.modeloconceitual.domain.Cliente;
import com.guttomarttins.modeloconceitual.domain.Endereco;
import com.guttomarttins.modeloconceitual.domain.Estado;
import com.guttomarttins.modeloconceitual.domain.Produto;
import com.guttomarttins.modeloconceitual.domain.enums.TipoCliente;
import com.guttomarttins.modeloconceitual.repositories.CategoriaRepository;
import com.guttomarttins.modeloconceitual.repositories.CidadeRepository;
import com.guttomarttins.modeloconceitual.repositories.ClienteRepository;
import com.guttomarttins.modeloconceitual.repositories.EnderecoRepository;
import com.guttomarttins.modeloconceitual.repositories.EstadoRepository;
import com.guttomarttins.modeloconceitual.repositories.ProdutoRepository;

@SpringBootApplication
public class ModeloconceitualApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(ModeloconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerias");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "453450387403", TipoCliente.PESSOAFISICA);
		cl1.getTelefones().addAll(Arrays.asList("23344523", "986753344"));

		Endereco e1 = new Endereco(null, "Rua Brasil", "10", "Apt. 203", "Centro", "45434564", cl1, c1);
		Endereco e2 = new Endereco(null, "Av Rio Branco", "1", "Sala 10", "Centro", "45768903", cl1, c2);

		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.save(cl1);
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}
}
