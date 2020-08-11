package mb.amazul.siscad.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mb.amazul.siscad.utils.TransactionType;
@Entity(name = "log_trace")
@Table(name = "log_trace")
@AttributeOverride(name = "id", column = @Column(name = "log_trace_id"))
public class LogTrace extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8678046397807889880L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "entity_name", nullable = false)
    private String entityName;

    @Column(name = "registry_id", nullable = false)
    private Long registryId;

    @Column(name = "operation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executed_by", nullable = false)
    private Usuario executedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Long getRegistryId() {
		return registryId;
	}

	public void setRegistryId(Long registryId) {
		this.registryId = registryId;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Usuario getExecutedBy() {
		return executedBy;
	}

	public void setExecutedBy(Usuario executedBy) {
		this.executedBy = executedBy;
	}

	

    
}