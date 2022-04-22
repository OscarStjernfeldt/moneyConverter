import org.example.convert.Converter;
import org.example.provide.Cny;
import org.example.provide.Eur;
import org.example.provide.Gbp;
import org.example.provide.Jpy;
import org.example.provide.Usd;

module org.example.convertprovider {
    requires org.example.convert;
    provides Converter with Eur, Usd, Gbp, Jpy, Cny;
    exports org.example.provide;
}