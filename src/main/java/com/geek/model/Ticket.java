package com.geek.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.geek.dateAudit.DateAudit;

@Entity
@Table(name = "tickets")
public class Ticket extends DateAudit {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "adviser_id")
	private Adviser adviser;

	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateAttention", nullable = false)
	private Date dateAttention;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateService")
	private Date dateService;

	@NotEmpty(message = "Please enter a typeservice")
	@Column(name = "typeService")
	private String typeService;

	@NotEmpty(message = "Please enter a status")
	private String status;

	@NotEmpty(message = "Please enter a address.")
	private String address;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_id")
	private List<TicketTechnician> ticketTechnicians;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ticket_problems", joinColumns = { @JoinColumn(name = "problem_id") }) // aqui se agrego
	@NotEmpty(message = "Por favor ingrese al menos un problema para el ticket")
	private List<Problem> problems = new ArrayList<>();

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Ticket() {
		this.setCreatedAt(new Date());
		this.setUpdatedAt(new Date());
	}

	public Ticket(Long id, Client client, Date dateAttention, Date dateService,
			@NotEmpty(message = "Please enter a typeservice") String typeService,
			@NotEmpty(message = "Please enter a status") String status,
			@NotEmpty(message = "Please enter a address.") String address) {
		super();
		this.id = id;
		this.client = client;
		this.dateAttention = dateAttention;
		this.dateService = dateService;
		this.typeService = typeService;
		this.status = status;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateAttention() {
		return dateAttention;
	}

	public void setDateAttention(Date dateAttention) {
		this.dateAttention = dateAttention;
	}

	public Date getDateService() {
		return dateService;
	}

	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addTicketTech(TicketTechnician item) {
		this.ticketTechnicians.add(item);
	}

	public Adviser getAdviser() {
		return adviser;
	}

	public void setAdviser(Adviser adviser) {
		this.adviser = adviser;
	}
	
	

}
