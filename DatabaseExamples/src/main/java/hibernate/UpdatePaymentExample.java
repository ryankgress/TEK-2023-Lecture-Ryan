package hibernate;

public class UpdatePaymentExample {

	public static void main(String[] args) {
		// Query the payment we just created by its id
		// Change the check number and amount
		// Update the payment
		
		PaymentDAO paymentDao = new PaymentDAO();
		
		Payment p = paymentDao.findById(284);
		
		p.setCheckNumber("NEWCH3CK");
		p.setAmount(8675309.00);

		paymentDao.update(p);
	}

}
