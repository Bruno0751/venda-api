package com.dev.venda_api.model;

import java.io.Serializable;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.Getter;
//import lombok.ToString;
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@ToString
@Entity
@Table(name = "venda")
public class VendaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venda")
    private Long id;

    @Column(name = "name_product", length = 100, unique = true)
    private String nameProduct;

    @OneToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_audit", referencedColumnName = "id_audit", foreignKey = @ForeignKey(name = "fk_venda_audit"))
    private Audit idAudit;

    public Long getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Audit getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(Audit idAudit) {
        this.idAudit = idAudit;
    }
}
