package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

@Test
public void eiVoiLisataNegatiivistaMaaraa(){
    varasto.lisaaVarastoon(-2);
    
    assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
}
  

@Test
public void josLisataanLiikaaEiSaldoYlitaTilavuutta(){
    varasto.lisaaVarastoon(20);
    
    assertEquals(10, varasto.getSaldo(),vertailuTarkkuus);
}

@Test
public void eiVoiOttaaNegatiivistaMaaraa(){
    varasto.lisaaVarastoon(5);
    varasto.otaVarastosta(-2);
    
    assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
}

@Test
public void kaikkiAnnetaanMitaVoidaan(){
    varasto.lisaaVarastoon(5);
    varasto.otaVarastosta(7);
    
    assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
}

@Test
public void toStringPalauttaaOikein(){
    varasto.lisaaVarastoon(5);
    
    assertEquals("saldo = 5.0, vielä tilaa 5.0",varasto.toString() );
    
}
@Test
public void konstruktorissaNegatiivinenTilavuusJolloinTilavuudeksiNolla(){
    Varasto varasto2=new Varasto(-2);

    assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
}

@Test
public void konstruktorissaPosTilavuusAsettaaTilavuudenOikein(){
    
Varasto varasto1=new Varasto(10.0,2.0);
assertEquals(10.0, varasto1.getTilavuus(),vertailuTarkkuus);
}

@Test
public void konstruktorissaTilavuusNollaTilavuudeksiAsetetaanNolla(){
    Varasto varasto1=new Varasto(0.0,2.0);
assertEquals(0.0, varasto1.getTilavuus(),vertailuTarkkuus);
    
}

@Test
public void konstruktorissaTilavuusNegatiivinenTilavuudeksiAsetetaanNolla(){
    Varasto varasto1=new Varasto(10.0,-1.0);
assertEquals(0.0, varasto1.getSaldo(),vertailuTarkkuus);
    
}
}
