package io.ketlv;

import com.owlike.genson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

/**
 * DiplomaQueryResult structure used for handling result of query
 */
@DataType()
public class DiplomaQueryRes {
    @Property()
    private final String key;
    @Property()
    private final Diploma record;

    public DiplomaQueryRes(@JsonProperty("Key") String key, @JsonProperty("Record") Diploma record) {
        this.key = key;
        this.record = record;
    }

    public String getKey() {
        return key;
    }

    public Diploma getRecord() {
        return record;
    }

    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        DiplomaQueryRes that = (DiplomaQueryRes) object;

        return new org.apache.commons.lang3.builder.EqualsBuilder().appendSuper(super.equals(object)).append(key, that.key).append(record, that.record).isEquals();
    }

    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(key).append(record).toHashCode();
    }
}
