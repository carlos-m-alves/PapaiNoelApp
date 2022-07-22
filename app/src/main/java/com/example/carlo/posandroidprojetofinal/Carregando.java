package com.example.carlo.posandroidprojetofinal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.carlo.posandroidprojetofinal.bean.Bairro;
import com.example.carlo.posandroidprojetofinal.bean.Carta;
import com.example.carlo.posandroidprojetofinal.bean.Cidade;
import com.example.carlo.posandroidprojetofinal.bean.Empresa;
import com.example.carlo.posandroidprojetofinal.bean.Evento;
import com.example.carlo.posandroidprojetofinal.bean.Instituicao;
import com.example.carlo.posandroidprojetofinal.bean.Relatorio;
import com.example.carlo.posandroidprojetofinal.bean.TipoBrinquedo;
import com.example.carlo.posandroidprojetofinal.bean.Usuario;
import com.example.carlo.posandroidprojetofinal.facade.BairroFacade;
import com.example.carlo.posandroidprojetofinal.facade.CartaFacade;
import com.example.carlo.posandroidprojetofinal.facade.CidadeFacade;
import com.example.carlo.posandroidprojetofinal.facade.EmpresaFacade;
import com.example.carlo.posandroidprojetofinal.facade.EventoFacade;
import com.example.carlo.posandroidprojetofinal.facade.InstituicaoFacade;
import com.example.carlo.posandroidprojetofinal.facade.TipoBrinquedoFacade;
import com.example.carlo.posandroidprojetofinal.service.BairroCallback;
import com.example.carlo.posandroidprojetofinal.service.CartaCallback;
import com.example.carlo.posandroidprojetofinal.service.CidadeCallback;
import com.example.carlo.posandroidprojetofinal.service.EmpresaCallback;
import com.example.carlo.posandroidprojetofinal.service.EventoCallback;
import com.example.carlo.posandroidprojetofinal.service.InstituicaoCallback;
import com.example.carlo.posandroidprojetofinal.service.TipoBrinquedoCallback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carregando extends AppCompatActivity {
    Usuario usuario = new Usuario();
    private static int SPLASH_TIME_OUT = 2500;
    int qtdEventos = 0;
    int qtdInstituicoes = 0;
    int qtdPadrinhos = 0;
    int quantidadeCartasApadrinhadas = 0;
    int qtdCartasApadrinhadasPorEmpresa = 0;
    int qtdTotalCartas = 0;

    List<Instituicao> listInst = new ArrayList<>();
    List<Carta> listCartas = new ArrayList<>();
    List<TipoBrinquedo> listTipoBrinquedo = new ArrayList<>();
    List<Bairro> listBairro = new ArrayList<>();
    List<Cidade> listCidade = new ArrayList<>();
    List<Instituicao> listInstituicao = new ArrayList<>();
    List<Empresa> listEmpresa = new ArrayList<>();
    //final Instituicao instituicao = new Instituicao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregando);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mIntent = getIntent();
                String previousActivity = mIntent.getStringExtra("nomeActivity");
                String criar = (String) mIntent.getStringExtra("criar");
                String editar = (String) mIntent.getStringExtra("editar");
                System.out.println("nomeAct: "+previousActivity);
                //System.out.println("criar: "+mIntent.getStringExtra("grafico"));
                //System.out.println("oq tem em GRAFICO: "+editar);
                if( previousActivity.equals("ListaInstituicao") && (mIntent.getStringExtra("funcao").equals("EditarInstituicao")) ){
                //    if( (previousActivity.equals("ListaInstituicao")) && ("EditarInstituicao".equals(mIntent.getStringExtra("editar"))) ) {
                    System.out.println("vai edita instituicao");
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList) obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    CidadeFacade.buscarTodos(new CidadeCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCidade = (ArrayList) obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(Carregando.this, EditarInstituicao.class);
                            Bundle dados = getIntent().getExtras();
                            i.putExtra("instituicao", (Serializable) dados.getSerializable("instituicao"));
                            i.putExtra("listBairro", (Serializable) listBairro);
                            i.putExtra("listCidade", (Serializable) listCidade);
                            startActivity(i);
                            finish();
                        }
                    }, 2000);
                }else if( previousActivity.equals("ListaInstituicao") && (mIntent.getStringExtra("funcao").equals("CriarInstituicao")) ){
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList) obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    CidadeFacade.buscarTodos(new CidadeCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCidade = (ArrayList) obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    System.out.println("vai criar insti");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(Carregando.this, CriarInstituicao.class);
                            Bundle dados = getIntent().getExtras();
                            i.putExtra("listBairro", (Serializable) listBairro);
                            i.putExtra("listCidade", (Serializable) listCidade);
                            startActivity(i);
                            finish();
                        }
                    }, 2000);
                }else if( previousActivity.equals("ListaEmpresas") ){
                    if( "EditarEmpresa".equals(editar) ) {
                        Bundle dados = getIntent().getExtras();
                        Empresa empresa = (Empresa) dados.getSerializable("empresa");
                        Intent i = new Intent(Carregando.this, EditarEmpresa.class);
                        i.putExtra("empresa",empresa);
                        startActivity(i);

                        //startActivity(new Intent(Carregando.this, EditarEmpresa.class));
                        finish();
                    }
                    if( "CriarEmpresa".equals(criar) ){
                        startActivity(new Intent(Carregando.this, CriarEmpresa.class));
                        finish();
                    }
                }else if( previousActivity.equals("Funcionalidades_funcionario") && (mIntent.getStringExtra("funcao").equals("listaEventos")) ){
                    System.out.println("entrou nas funcionalidades");
                    EventoFacade.buscarTodos(new EventoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            List<Evento> lista = (List<Evento>)obj;
                            Intent i = new Intent(Carregando.this, ListaEventos.class);
                            i.putExtra("eventos",(Serializable) lista);
                            startActivity(i);
                            finish();
                        }
                        @Override
                        public void onFailure(Throwable t) {
                            System.out.println("deu erro: "+t.getMessage());
                        }
                    });
                }else if( previousActivity.equals("Funcionalidades_funcionario") && (mIntent.getStringExtra("funcao").equals("listaInstituicoes")) ){
                    System.out.println("entrou na lista instituicoes");

                    InstituicaoFacade.buscarTodos(new InstituicaoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listInst = (ArrayList)obj;
                            System.out.println("");
                            Intent i = new Intent(Carregando.this, ListaInstituicao.class);
                            i.putExtra("listInst",(Serializable) listInst);
                            startActivity(i);
                            finish();
                        }
                        @Override
                        public void onFailure(Throwable t) {
                            System.out.println("erro: "+t.getMessage());
                        }
                    });
                }else if( previousActivity.equals("ListaInstituicao") && (mIntent.getStringExtra("funcao").equals("CriarInstituicao")) ){
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    CidadeFacade.buscarTodos(new CidadeCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCidade = (ArrayList)obj;
                            for(Cidade cidade : listCidade){
                                System.out.println("cidade do bd: "+cidade.getNomeCidade());
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    System.out.println("chegou funcao criar instituicao");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(Carregando.this, CriarInstituicao.class);
                            i.putExtra("listBairro",(Serializable)listBairro);
                            i.putExtra("listCidade",(Serializable)listCidade);
                            startActivity(i);
                            finish();
                        }
                    },2000);
                }else if( previousActivity.equals("Funcionalidades_funcionario") && (mIntent.getStringExtra("funcao").equals("listaCartas")) ){
                    CartaFacade.buscarTodos(new CartaCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCartas = (ArrayList)obj;
                            for(Carta c : listCartas){
                                System.out.println("carta: "+c.getCrianca().getIdCrianca());
                                System.out.println("carta: "+c.getCrianca().getNomeCrianca());
                                System.out.println("id carta: "+c.getIdCarta());
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });
                    TipoBrinquedoFacade.buscarTodos(new TipoBrinquedoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listTipoBrinquedo = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });
                    InstituicaoFacade.buscarTodos(new InstituicaoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listInstituicao = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(Carregando.this, ListaCartasCadastradas.class);
                            i.putExtra("listCartas",(Serializable)listCartas);
                            i.putExtra("listTipoBrinquedo",(Serializable)listTipoBrinquedo);
                            i.putExtra("listBairro",(Serializable)listBairro);
                            i.putExtra("listInstituicao",(Serializable)listInstituicao);
                            startActivity(i);
                            finish();
                        }
                    },3000);
                }else if( previousActivity.equals("ListaCartasCadastradas") && (mIntent.getStringExtra("funcao").equals("cadastro")) ){
                    TipoBrinquedoFacade.buscarTodos(new TipoBrinquedoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listTipoBrinquedo = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });
                    InstituicaoFacade.buscarTodos(new InstituicaoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listInstituicao = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {
                        }
                    });
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(Carregando.this, CadastrarCarta.class);
                            i.putExtra("listTipoBrinquedo",(Serializable)listTipoBrinquedo);
                            i.putExtra("listBairro",(Serializable)listBairro);
                            i.putExtra("listInstituicao",(Serializable)listInstituicao);
                            startActivity(i);
                            finish();
                        }
                    },2000);

                }else if( previousActivity.equals("ListaEventos") && (mIntent.getStringExtra("funcao").equals("editar")) ){
                    System.out.println("CHEGOU NO EDITAR EVENTO");
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro=(ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    CidadeFacade.buscarTodos(new CidadeCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCidade=(ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    EmpresaFacade.buscarTodos(new EmpresaCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listEmpresa=(ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Bundle dados = getIntent().getExtras();
                            Evento evento = (Evento) dados.getSerializable("evento");
                            Intent i = new Intent(Carregando.this, EditarEvento.class);
                            i.putExtra("listEmpresa",(Serializable)listEmpresa);
                            i.putExtra("listBairro",(Serializable)listBairro);
                            i.putExtra("listCidade",(Serializable)listCidade);
                            i.putExtra("evento",evento);
                            startActivity(i);
                            finish();
                        }
                    },2000);
                }else if( previousActivity.equals("ListaEventos") && (mIntent.getStringExtra("funcao").equals("criar")) ){
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    CidadeFacade.buscarTodos(new CidadeCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCidade = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    EmpresaFacade.buscarTodos(new EmpresaCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listEmpresa = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    System.out.println("chegou funcao chamar criarEvento");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(Carregando.this, CriarEvento.class);
                            i.putExtra("listBairro",(Serializable)listBairro);
                            i.putExtra("listCidade",(Serializable)listCidade);
                            i.putExtra("listEmpresa",(Serializable)listEmpresa);
                            startActivity(i);
                            finish();
                        }
                    },2000);
                }else if( previousActivity.equals("ListaRelatorios") ){
                    if( mIntent.getStringExtra("grafico").equals("GraficoUm") ) {
                        CartaFacade.brinquedosMaisPedidos(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> lista = (List<Relatorio>)obj;
                                for(Relatorio r : lista){
                                    System.out.println("rel: "+r.getDescricao());
                                }
                                Intent i = new Intent(Carregando.this, GraficoUm.class);
                                i.putExtra("graficoUm",(Serializable) lista);
                                startActivity(i);
                                finish();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                    }
                    else if( mIntent.getStringExtra("grafico").equals("GraficoDois") ) {
                        CartaFacade.getQtdEventos(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> r = (ArrayList)obj;
                                qtdEventos = r.get(0).getValorInteiro();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                        CartaFacade.qtdInstituicoes(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> r = (ArrayList)obj;
                                qtdInstituicoes = r.get(0).getValorInteiro();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                        CartaFacade.qtdPadrinhos(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> r = (ArrayList)obj;
                                qtdPadrinhos = r.get(0).getValorInteiro();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                        CartaFacade.quantidadeCartasApadrinhadas(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> r = (ArrayList)obj;
                                quantidadeCartasApadrinhadas = r.get(0).getValorInteiro();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                        CartaFacade.qtdCartasApadrinhadasPorEmpresa(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> r = (ArrayList)obj;
                                qtdCartasApadrinhadasPorEmpresa = r.get(0).getValorInteiro();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                        CartaFacade.quantidadeTotalCartas(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> r = (ArrayList)obj;
                                qtdTotalCartas = r.get(0).getValorInteiro();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent it = new Intent(Carregando.this, GraficoDois.class);
                                it.putExtra("qtdEventos", qtdEventos);
                                it.putExtra("qtdInstituicoes", qtdInstituicoes);
                                it.putExtra("qtdPadrinhos", qtdPadrinhos);
                                it.putExtra("qtdTotalCartas", qtdTotalCartas);
                                it.putExtra("quantidadeCartasApadrinhadas", quantidadeCartasApadrinhadas);
                                it.putExtra("qtdCartasApadrinhadasPorEmpresa", qtdCartasApadrinhadasPorEmpresa);
                                startActivity(it);
                                finish();
                            }
                        },3000);
                    }
                    else if( mIntent.getStringExtra("grafico").equals("GraficoTres") ) {
                        System.out.println("chegou no graficoTRES");
                        CartaFacade.criancasPorInstituicao(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> lista = (List<Relatorio>)obj;
                                for(Relatorio r : lista){
                                    System.out.println("rel: "+r.getDescricao());
                                }
                                Intent i = new Intent(Carregando.this, GraficoTres.class);
                                i.putExtra("graficoTres",(Serializable) lista);
                                startActivity(i);
                                finish();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                    }
                    else if( mIntent.getStringExtra("grafico").equals("graficoQuatro") ) {
                        CartaFacade.criancasPorInstituicao(new CartaCallback() {
                            @Override
                            public void onSuccess(Object obj) {
                                List<Relatorio> lista = (List<Relatorio>)obj;
                                for(Relatorio r : lista){
                                    System.out.println("rel: "+r.getDescricao());
                                }
                                Intent i = new Intent(Carregando.this, GraficoUm.class);
                                i.putExtra("graficoQuatro",(Serializable) lista);
                                startActivity(i);
                                finish();
                            }

                            @Override
                            public void onFailure(Throwable t) {

                            }
                        });
                    }
                }else if( previousActivity.equals("FiltrarCartas") && (mIntent.getStringExtra("funcao").equals("pesquisaCartasPorBrinquedo")) ){
                    int idTipoBrinquedo = getIntent().getExtras().getInt ("idTipoBrinquedo");
                    System.out.println("tipo do brinquedo: "+idTipoBrinquedo);
                    CartaFacade.buscarCartasPorTipoBrinquedo(idTipoBrinquedo, new CartaCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCartas = (ArrayList)obj;
                            Intent it = new Intent(Carregando.this, ListaCartas.class);
                            it.putExtra("listaCartas", (Serializable) listCartas);
                            it.putExtra("usuario", (Serializable) usuario);
                            startActivity(it);
                            finish();
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                }else if( previousActivity.equals("FiltrarCartas") ){
                    CartaFacade.buscarTodos(new CartaCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            List<Carta> lista = (List<Carta>)obj;
                            for(Carta c: lista){
                                System.out.println("carta: "+c.getDescricao());
                            }
                            //System.out.println("retornou algo");

                            Intent it = new Intent(Carregando.this, ListaCartas.class);
                            //it.putExtra("listaCartas",lista);
                            it.putExtra("listaCartas", (Serializable) lista);
                            startActivity(it);
                            finish();
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(Carregando.this,"Não foi possível buscar as cartas.",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else if( previousActivity.equals("Funcionalidades_Usuario") && (mIntent.getStringExtra("funcao").equals("ListaCartasApadrinhadas")) ){
                    CartaFacade.buscarCartasPadrinho(usuario.getId(), new CartaCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCartas = (ArrayList)obj;
                            Intent it = new Intent(Carregando.this, ListaCartasApadrinhadas.class);
                            it.putExtra("listCartas", (Serializable) listCartas);
                            it.putExtra("usuario", (Serializable) usuario);
                            for (Carta cc : listCartas){
                                System.out.println("carta apad: "+cc.getCrianca().getNomeCrianca());
                            }
                            startActivity(it);
                            finish();
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                }else if( previousActivity.equals("Funcionalidades_Usuario") && (mIntent.getStringExtra("funcao").equals("pesquisarCartas")) ){
                    TipoBrinquedoFacade.buscarTodos(new TipoBrinquedoCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listTipoBrinquedo = (ArrayList)obj;
                            Intent it = new Intent(Carregando.this, FiltrarCartas.class);
                            it.putExtra("listTipoBrinquedo", (Serializable) listTipoBrinquedo);
                            it.putExtra("usuario", (Serializable) usuario);
                            startActivity(it);
                            finish();
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                }else if( previousActivity.equals("EscolheTipoPadrinho") && (mIntent.getStringExtra("funcao").equals("criarPadEmpresa")) ){
                    BairroFacade.buscarTodos(new BairroCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listBairro = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    CidadeFacade.buscarTodos(new CidadeCallback() {
                        @Override
                        public void onSuccess(Object obj) {
                            listCidade = (ArrayList)obj;
                        }

                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent it = new Intent(Carregando.this, CadastrarPadEmpresa.class);
                            it.putExtra("listBairro",(Serializable) listBairro);
                            it.putExtra("listCidade",(Serializable) listCidade);
                            startActivity(it);
                            finish();
                        }
                    },3000);

                }else{
                    System.out.println("NAO ENTROU NO PRIM IF");
                }
            }
        },SPLASH_TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Usuario usu = (Usuario) getIntent().getExtras().getSerializable("usuario");
        usuario = usu;
    }
}
