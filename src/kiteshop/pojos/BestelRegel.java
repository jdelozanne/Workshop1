package kiteshop.pojos;

public class BestelRegel {
	
	int aantal;
	Product product;
	
	public BestelRegel(Product product, int aantal) {
		this.product = product;
                this.aantal = aantal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aantal;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BestelRegel other = (BestelRegel) obj;
		if (aantal != other.aantal)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

    @Override
    public String toString() {
        
        return "BestelRegel{" + "aantal=" + aantal + ", product=" + product + '}';
    }

}
