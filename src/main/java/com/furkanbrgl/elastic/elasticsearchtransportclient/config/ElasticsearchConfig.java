package com.furkanbrgl.elastic.elasticsearchtransportclient.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticsearchConfig {

    @Valid
    private ElasticConfig elastic = new ElasticConfig();

    @Valid
    private WebsiteConfig website = new WebsiteConfig();

    @Bean
    public Client client() {

        Settings esSettings = Settings.builder()
                .put("cluster.name", elastic.getClusterName())
                .build();

        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(esSettings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elastic.getHost()), elastic.getPort()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

/*
    @Bean
    public Client client() {
        Settings esSettings = Settings.builder().put("cluster.name", elastic.getClusterName())
                .build();
        Client client = null;
        try {
            client = TransportClient.builder()
                    .settings(esSettings)
                    .build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elastic.getHost()), elastic.getPort()));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
*/
 /*
    //For Spring Data Elastic
    @Bean
    public ElasticsearchOperations elasticsearchOperations() {
        return new ElasticsearchTemplate(client());
    }
*/


    public ElasticConfig getElastic() {
        return elastic;
    }

    public void setElastic(ElasticConfig elastic) {
        this.elastic = elastic;
    }

    public WebsiteConfig getWebsite() {
        return website;
    }

    public void setWebsite(WebsiteConfig website) {
        this.website = website;
    }

    public static class ElasticConfig {

        public String clusterName;
        public String host;
        public int port;

        public String getClusterName() {
            return clusterName;
        }

        public void setClusterName(String clusterName) {
            this.clusterName = clusterName;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }
    }

    public static class WebsiteConfig {

        public String esIndex;

        public String getEsIndex() {
            return esIndex;
        }

        public void setEsIndex(String esIndex) {
            this.esIndex = esIndex;
        }

    }

}