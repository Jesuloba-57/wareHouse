import java.util.*;
import java.io.*;

public class InvoiceList implements Serializable {
    private List<Invoice> invoices = new LinkedList();
    private static InvoiceList invoiceList;

    private InvoiceList() {
    }

    public static InvoiceList instance() {
        if (invoiceList == null) {
            return (invoiceList = new InvoiceList());
        } else {
            return invoiceList;
        }
    }

    public boolean addToInvoices(Invoice invoice) {
        invoices.add(invoice);
        return true;
    }

    public boolean removeFromInvoices(Invoice invoice) {
        boolean removed = invoices.remove(invoice);
        return removed;
    }

    public Iterator getInvoices() {
        return invoices.iterator();
    }
}
