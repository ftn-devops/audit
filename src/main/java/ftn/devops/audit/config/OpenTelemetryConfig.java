package ftn.devops.audit.config;

import ch.qos.logback.core.net.SyslogOutputStream;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.exporter.otlp.http.logs.OtlpHttpLogRecordExporter;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfig {

    @Bean
    public Tracer tracer() {

        return GlobalOpenTelemetry.getTracer("ftn.devops.audit");
    }

    @Bean
    OtlpHttpLogRecordExporter otlpHttpLogExporter(@Value("${tracing.http.url}") String url) {
        System.out.println("Seting up otlp http log exporter : "+ url);
        return OtlpHttpLogRecordExporter.builder()
                .setEndpoint(url)
                .build();
    }

    @Bean
    OtlpGrpcLogRecordExporter otlpGrpcLogRecordExporter(@Value("${tracing.grpc.url}") String url) {
        System.out.println("Seting up otlp grpc log exporter : "+ url);
        return OtlpGrpcLogRecordExporter.builder()
                .setEndpoint(url)
                .build();
    }

    @Bean
    OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.http.url}") String url) {
        System.out.println("Seting up otlp http span exporter : "+ url);
        return OtlpHttpSpanExporter.builder()
                .setEndpoint(url)
                .build();
    }

    @Bean
    OtlpGrpcSpanExporter otlpGrpcSpanExporter(@Value("${tracing.grpc.url}") String url) {
        System.out.println("Seting up otlp grpc span exporter : "+ url);
        return OtlpGrpcSpanExporter.builder()
                .setEndpoint(url)
                .build();
    }
}
