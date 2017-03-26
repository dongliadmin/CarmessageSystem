package com.yzk.carsystem.model;

public class CarMaster {
	private int id;
	private String name;
	private Long tel;
	private String addres;
	private String carbrand;
	private String number;
	private String note;
	private Vip vip;

	public CarMaster() {
		super();
	}

	public CarMaster(int id, String name, Long tel, String addres, String carbrand, String number, String note,
			Vip vip) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addres = addres;
		this.carbrand = carbrand;
		this.number = number;
		this.note = note;
		this.vip = vip;
	}

	public CarMaster(String name, Long tel, String addres, String carbrand, String number, String note, Vip vip) {
		super();
		this.name = name;
		this.tel = tel;
		this.addres = addres;
		this.carbrand = carbrand;
		this.number = number;
		this.note = note;
		this.vip = vip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTel() {
		return tel;
	}

	public void setTel(Long tel) {
		this.tel = tel;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getCarbrand() {
		return carbrand;
	}

	public void setCarbrand(String carbrand) {
		this.carbrand = carbrand;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Vip getVip() {
		return vip;
	}

	public void setVip(Vip vip) {
		this.vip = vip;
	}

	@Override
	public String toString() {
		return "CarMaster [id=" + id + ", name=" + name + ", tel=" + tel + ", addres=" + addres + ", carbrand="
				+ carbrand + ", number=" + number + ", note=" + note + ", vip=" + vip + "]";
	}

}