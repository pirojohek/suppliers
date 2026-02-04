package by.pirog.suppliers.exception;

public class SupplyNotFoundException extends RuntimeException {
  public SupplyNotFoundException(String message) {
    super(message);
  }
}
