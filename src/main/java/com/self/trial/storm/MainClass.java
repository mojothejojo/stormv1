package com.self.trial.storm;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;

public class MainClass {
    public static void main(String[] args) {
        TopologyBuilder builder =new TopologyBuilder();
        builder.setSpout("basicSpout",new CustomSpout());
        builder.setBolt("basicBolt",new CustomBolt())
                .shuffleGrouping("basicSpout");

        Config conf=new Config();

        StormTopology top=builder.createTopology();

        try {
            StormSubmitter.submitTopology("trial",
                    conf,
                    top);
        } catch (AlreadyAliveException e) {
            e.printStackTrace();
        } catch (InvalidTopologyException e) {
            e.printStackTrace();
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
    }
}
