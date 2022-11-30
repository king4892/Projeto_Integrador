package com.springboot.application.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="fornecedor")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotEmpty
	private String cnpj;
	
	@Column
	@NotEmpty
	private String telefone;
	
	@Column

	@NotEmpty
	private String email;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Produto produto;	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private Conta_Pagar conta_pagar;
	
	
	@OneToOne( cascade = CascadeType.ALL, orphanRemoval = true )
	private Endereco endereco;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(Long id, @NotEmpty String cnpj, @NotEmpty String telefone, @NotEmpty String email,
			Produto produto,  Endereco endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.produto = produto;
		
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

	
	
	
}
