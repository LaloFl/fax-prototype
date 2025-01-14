package fax.fax_prototype.persistence.fax;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "public", name = "fax")
public class Fax {

    public Fax() {
    }

    public Fax(String faxNumber, String faxTemplateId, byte[] faxData) {
        this.faxNumber = faxNumber;
        this.faxTemplateId = faxTemplateId;
        this.faxData = faxData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "fax_number", nullable = false)
    private String faxNumber;

    @Column(name = "fax_template_id", nullable = false)
    private String faxTemplateId;

    @Column(name = "fax_data", nullable = false)
    private byte[] faxData;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "completed_at")
    private Timestamp completedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFaxTemplateId() {
        return faxTemplateId;
    }

    public void setFaxTemplateId(String faxTemplateId) {
        this.faxTemplateId = faxTemplateId;
    }

    public byte[] getFaxData() {
        return faxData;
    }

    public void setFaxData(byte[] faxData) {
        this.faxData = faxData;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Timestamp completedAt) {
        this.completedAt = completedAt;
    }
}
