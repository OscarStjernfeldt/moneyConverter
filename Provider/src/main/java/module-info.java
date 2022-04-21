import org.example.convert.Converter;
import org.example.provide.ConvertFromSekToCny;
import org.example.provide.ConvertFromSekToEur;
import org.example.provide.ConvertFromSekToGbp;
import org.example.provide.ConvertFromSekToJpy;
import org.example.provide.ConvertFromSekToUsd;

module org.example.convertprovider {
    requires org.example.convert;
    provides Converter with ConvertFromSekToEur,ConvertFromSekToUsd, ConvertFromSekToGbp, ConvertFromSekToJpy, ConvertFromSekToCny;
}