package com.song.hasor;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.core.Hasor;
import net.hasor.core.Module;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@DimModule
@Component()
public class MyModule implements Module {
  @Autowired
  private DataSource dataSource = null;
  @Override
  public void loadModule(ApiBinder apiBinder) throws Throwable {

    // .DataSource form Spring boot into Hasor
    apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
  }
}