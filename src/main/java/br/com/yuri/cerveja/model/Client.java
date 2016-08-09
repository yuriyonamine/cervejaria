package br.com.yuri.cerveja.model;

public class Client {
	private String name;
	private TipoPessoa personType;
	private String cpfCNPJ;
	private String phone;
	private String email;
	private String publicPlaceName; 
	private short number;
	private short complement;
	private String zipCode;
	private String state;
	private String city;
	public String getName() {
		return name;
	}
	public void setName(String nome) {
		this.name = nome;
	}
	public TipoPessoa getPersonType() {
		return personType;
	}
	public void setPersonType(TipoPessoa tipoPessoa) {
		this.personType = tipoPessoa;
	}
	public String getCpfCNPJ() {
		return cpfCNPJ;
	}
	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String telefone) {
		this.phone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPublicPlaceName() {
		return publicPlaceName;
	}
	public void setPublicPlaceName(String logradouro) {
		this.publicPlaceName = logradouro;
	}
	public short getNumber() {
		return number;
	}
	public void setNumber(short numero) {
		this.number = numero;
	}
	public short getComplement() {
		return complement;
	}
	public void setComplement(short complemento) {
		this.complement = complemento;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String cep) {
		this.zipCode = cep;
	}
	public String getState() {
		return state;
	}
	public void setState(String estado) {
		this.state = estado;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String cidade) {
		this.city = cidade;
	}


}
