import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Datum {

    @SerializedName("id")
    private Long mId;
    @SerializedName("nama")
    private String mNama;
    @SerializedName("nis")
    private Long mNis;
    @SerializedName("status")
    private String mStatus;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getNama() {
        return mNama;
    }

    public void setNama(String nama) {
        mNama = nama;
    }

    public Long getNis() {
        return mNis;
    }

    public void setNis(Long nis) {
        mNis = nis;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
