package com.bancodesangue.controller;

import java.io.IOException;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bancodesangue.repository.DoadorRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bancodesangue.model.Doador;
import com.bancodesangue.model.custom.DoadorGenero;
import com.bancodesangue.model.custom.DoadorPorEstado;
import com.bancodesangue.model.custom.DoadorPossivel;

@Controller
public class DoadorController {

	@Autowired
	DoadorRepository dr;
	ObjectMapper objectMapper = new ObjectMapper();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String form() throws JsonParseException, JsonMappingException, IOException {

		List<Doador> doador = objectMapper.readValue(new File("data.json"), new TypeReference<List<Doador>>() {
		});
		int i = 0;
		int aux = doador.size();

		while (i < aux) {

			Doador d = new Doador();
			// d.setCodigo(i);
			d.setNome(doador.get(i).getNome());
			d.setAltura(doador.get(i).getAltura());
			d.setBairro(doador.get(i).getNome());
			d.setCelular(doador.get(i).getCelular());
			d.setCep(doador.get(i).getCep());
			d.setCidade(doador.get(i).getCidade());
			d.setCpf(doador.get(i).getCpf());
			d.setData_nasc(doador.get(i).getData_nasc());
			d.setEmail(doador.get(i).getEmail());
			d.setEndereco(doador.get(i).getEndereco());
			d.setEstado(doador.get(i).getEstado());
			d.setMae(doador.get(i).getMae());
			d.setNumero(doador.get(i).getNumero());
			d.setPai(doador.get(i).getNome());
			d.setPeso(doador.get(i).getPeso());
			d.setRg(doador.get(i).getRg());
			d.setSexo(doador.get(i).getSexo());
			d.setTelefone_fixo(doador.get(i).getTelefone_fixo());
			d.setTipo_sanguineo(doador.get(i).getTipo_sanguineo());

			dr.save(d);
			i++;
		}

		return "doador/formDoador";

	}

	@RequestMapping("/doadores")
	public ModelAndView listadDoadores() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Doador> doadores = dr.findAll();
		mv.addObject("doadores", doadores);
		return mv;
	}

	@RequestMapping("/cadastrarDoador") //fazer validações da tela
	public String form(Doador doador) {
		return "doador/formDoador";
	}

	@RequestMapping("/relatorioPorEstado")
	public ModelAndView listaDoadores() {
		ModelAndView mv = new ModelAndView("doador/formPorEstado");
		Iterable<DoadorPorEstado> doadoresPorEstado = dr.findAllDoadorPorEstado();
		mv.addObject("doadoresPorEstado", doadoresPorEstado);
		return mv;
	}

	@RequestMapping("/relatorioPorGenero")
	public ModelAndView listadeDoadoresPorGenero() {
		ModelAndView mv = new ModelAndView("doador/formIMCPorSexo");
		Iterable<DoadorGenero> doadoresGenero = dr.findAllFeminino();
		mv.addObject("doadoresGenero", doadoresGenero);

		Iterable<DoadorGenero> doadoresGeneros = dr.findAllMasculino();
		mv.addObject("doadoresGeneros", doadoresGeneros);

		return mv;
	}

	@RequestMapping("/relatorioPossiveisDoadores")
	public ModelAndView listadeDoadores() {
		ModelAndView mv = new ModelAndView("doador/formDoadoresPossiveis");
		Iterable<DoadorPossivel> doadoresPossiveisA = dr.findAllDoadoesPossiveisA();
		mv.addObject("doadoresPossiveisA", doadoresPossiveisA);

		Iterable<DoadorPossivel> doadoresPossiveisAN = dr.findAllDoadoesPossiveisAN();
		mv.addObject("doadoresPossiveisAN", doadoresPossiveisAN);

		Iterable<DoadorPossivel> doadoresPossiveisB = dr.findAllDoadoesPossiveisB();
		mv.addObject("doadoresPossiveisB", doadoresPossiveisB);

		Iterable<DoadorPossivel> doadoresPossiveisBN = dr.findAllDoadoesPossiveisBN();
		mv.addObject("doadoresPossiveisBN", doadoresPossiveisBN);

		Iterable<DoadorPossivel> doadoresPossiveisAB = dr.findAllDoadoesPossiveisAB();
		mv.addObject("doadoresPossiveisAB", doadoresPossiveisAB);

		Iterable<DoadorPossivel> doadoresPossiveisABN = dr.findAllDoadoesPossiveisABN();
		mv.addObject("doadoresPossiveisABN", doadoresPossiveisABN);

		Iterable<DoadorPossivel> doadoresPossiveisO = dr.findAllDoadoesPossiveisO();
		mv.addObject("doadoresPossiveisO", doadoresPossiveisO);

		Iterable<DoadorPossivel> doadoresPossiveisON = dr.findAllDoadoesPossiveisON();
		mv.addObject("doadoresPossiveisON", doadoresPossiveisON);

		return mv;
	}

	@RequestMapping(value = "/doadores", method = RequestMethod.POST)
	public String jsonDoadores(@PathVariable("codigo") long codigo) {
		Doador doador = dr.findByCodigo(codigo);
		doador.setCodigo(codigo);
		dr.save(doador);

		return "redirect:/cadastrarDoador";
	}

	@RequestMapping("/{codigo}")
	public ModelAndView detalhesDoador(@PathVariable("codigo") long codigo) {
		Doador doador = dr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("doador/detalhesDoador");
		mv.addObject("doador", doador);
		return mv;

	}

}
