package poc.drool.models;

public class Customer {
	 public String getDiscountReason() {
		return discountReason;
	}
	public void setDiscountReason(String discountReason) {
		this.discountReason = discountReason;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public String discountReason;
	 public double discount;
	 public int seniority;
	 
public String toString()
{
	return discountReason+" "+discount;
}
	 
	}