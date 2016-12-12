package com.mymart.vo;

public enum BookEnum {

	POTTER_1(1, "potter_1", 8), POTTER_2(2, "potter_2", 8), POTTER_3(3,
			"potter_3", 8), POTTER_4(4, "potter_4", 8), POTTER_5(5, "potter_5",
			8), POTTER_6(6, "potter_6", 8), POTTER_7(7, "potter_7", 8);

	public double price;

	public int productNumber;

	public String productTitle;

	private BookEnum(int productNumber, String productTitle, double price) {
		this.price = price;
		this.productNumber = productNumber;
		this.productTitle = productTitle;

	}

	public static BookEnum getByNumber(int number) {
		for (BookEnum book : values()) {
			if (book.productNumber == number) {
				return book;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return productNumber + " - " + productTitle + " - "
				+ String.format("$%.2f", price);
	}

}