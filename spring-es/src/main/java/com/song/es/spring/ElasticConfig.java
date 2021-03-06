package com.song.es.spring;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @ClassName ElasticConfig
 * @Description ElasticSearch搜索引擎配置
 * @Author wangd
 * @Create 2018-12-02 23:22
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.song.es.spring")
@Slf4j
public class ElasticConfig {
  /**
   * 主机
   */
  @Value("${elasticsearch.host}")
  private String esHost;

  /**
   * 传输层端口，注意和ES的Restful API默认9200端口有区分
   */
  @Value("${elasticsearch.port}")
  private int esPort;

  /**
   * 集群名称
   */
  @Value("${elasticsearch.clustername}")
  private String esClusterName;

  /**
   * 连接池
   */
  @Value("${elasticsearch.pool}")
  private String poolSize;

  @Bean
  public Client client() {
    log.info("开始初始化Elasticsearch");
    try {
      Settings esSettings = Settings.builder()
          .put("cluster.name", esClusterName)
          .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
          .put("thread_pool.search.size", Integer.parseInt(poolSize))//增加线程池个数，暂时设为5
          .build();

      //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html

      return new PreBuiltTransportClient(esSettings)
          .addTransportAddress(new TransportAddress(InetAddress.getByName(esHost), esPort));
    } catch (Exception e) {
      log.error("初始化Elasticsearch失败！", e);
      return null;
    }
  }


  @Bean
  public ElasticsearchOperations elasticsearchTemplate() {
    Client client = client();
    if (client != null) {
      return new ElasticsearchTemplate(client);
    } else {
      System.out.println("出错了");
      return null;
    }
  }

  //Embedded Elasticsearch Server
    /*@Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
    }*/
}
