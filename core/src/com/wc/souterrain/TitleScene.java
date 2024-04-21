package com.wc.souterrain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.ArrayList;

public class TitleScene extends Stage {
    //3 boutons principaux
    //1 textfield pour le pseudo
    //2 labels pour indiquer aux joueurs qu'ils doivent entrer leur nom et que c'est leur skin qu'ils choisissent
    //4 imagebuttons pour le skin
    //2 labels pour credits et explications
    //1 textfield pour le temps
    //Image du skin
    //1 boutons valider
    
    private TextButton startButton;
    private TextButton creditsButton;
    private TextButton quitButton;
    private TextField TFName;
    private Label selectTimeLb;
    public TextField selectTime;
    private ImageButton selectSkin1;
    private ImageButton selectSkin2;
    private ImageButton selectSkin3;
    private ImageButton selectSkin4;
    private Image selectedSkin;
    private ImageButton validateButton;
    private Label creditsLb;
    private ImageButton returnButton;
    private ImageButton returnTimeButton;
    private Label entreePseudoLb;
    private Label selectedSkinLb;
    public boolean finished;
    public boolean init;
    public ArrayList<String> spriteList;
    public ArrayList<String> nameList;
    public int clickedSkin;
    
    public TitleScene(Camera camera){
        super(new ScreenViewport(camera));
        
        Skin skin = new Skin(Gdx.files.internal("font/skinfile.json"));
        
        spriteList = new ArrayList<>();
        nameList = new ArrayList<>();
        clickedSkin = 0;
        init = false;
        
        startButton = new TextButton("Commencer",skin);
        //setTransparent(startButton);
        creditsButton = new TextButton("Credits",skin);
        //setTransparent(creditsButton);
        quitButton = new TextButton("Quitter", skin);
        //setTransparent(quitButton);
        
        TFName = new TextField("Pseudo",skin);
        setTransparent(TFName);
        selectTime = new TextField("Durée de la partie ",skin);
        setTransparent(selectTime);
        
        selectSkin1=new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("bonorme.png")))));
        setTransparent(selectSkin1);
        selectSkin1.setBounds(550,350,128, 128);
        selectSkin1.getImageCell().expand().fill();
        
        selectSkin2=new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("bonirme.png")))));
        setTransparent(selectSkin2);
        selectSkin2.setBounds(650,350,128, 128);
        selectSkin2.getImageCell().expand().fill();
        
        selectSkin3=new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("bonarme.png")))));
        setTransparent(selectSkin3);
        selectSkin3.setBounds(550,200,128, 128);
        selectSkin3.getImageCell().expand().fill();
        
        selectSkin4=new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("bonerme.png")))));
        setTransparent(selectSkin4);
        selectSkin4.setBounds(650,200,128, 128);
        selectSkin4.getImageCell().expand().fill();
        
        selectedSkin = new Image(new Texture (Gdx.files.internal("bones.png")));
        setTransparent(selectedSkin);
        selectedSkin.setBounds(50, 200, 128, 256);
        
        validateButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("arrow.png")))));
        setTransparent(validateButton);
        entreePseudoLb = new Label("Entrez votre pseudo ",skin);
        setTransparent(entreePseudoLb);
        selectedSkinLb = new Label("Choisissez votre skin ",skin);
        setTransparent(selectedSkinLb);
        
        creditsLb = new Label("Conception : Arnaud et Simon\n"
                            + "Developpement : Arnaud et Simon\n"
                            + "Sprites et Textures : Arnaud\n"
                            + "Gold II sur TFT : Simon\n"
                            + "\n"
                            + "Framework utilise : LibGDX\n"
                            + "Outils utilises : Tiled, Pixelorama, gitlab\n"
                            + "Inspiration sprites : Minecraft, Spelunky\n"
                            + "\n"
                            + "Dedicace a Mme Pacou et a Bob l'eponge",skin);
        setTransparent(creditsLb);
        
        returnButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("arrow.png")))));
        setTransparent(returnButton);
        
        returnTimeButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("arrow.png")))));
        setTransparent(returnTimeButton);
        
        selectTime = new TextField("0",skin);
        setTransparent(selectTime);
        
        selectTimeLb = new Label("Entrer la duree de la partie", skin);
        setTransparent(selectTimeLb);
        
        //écouteurs de clics :)[=B=|
        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                setTransparent(startButton);
                setTransparent(creditsButton);
                setTransparent(quitButton);
                setOpaque(TFName);
                setOpaque(selectSkin1);
                setOpaque(selectSkin2);
                setOpaque(selectSkin3);
                setOpaque(selectSkin4);
                setOpaque(selectedSkin);
                setOpaque(validateButton);
                setOpaque(entreePseudoLb);
                setOpaque(selectedSkinLb);    
            }
        });
        
        creditsButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                setTransparent(startButton);
                setTransparent(creditsButton);
                setTransparent(quitButton);
                setOpaque(creditsLb);
                setOpaque(returnButton);
            }
        });
        
        quitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                System.exit(0);
            }
        });
        
        selectSkin1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                if(!(spriteList.contains("bonorme.png"))){
                    selectedSkin.setDrawable(selectSkin1.getImage().getDrawable());
                    clickedSkin = 1;
                }
            }
        });
        
        selectSkin2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                if(!(spriteList.contains("bonirme.png"))){
                    selectedSkin.setDrawable(selectSkin2.getImage().getDrawable());
                    clickedSkin = 2;
                }
            }
        });
        
        selectSkin3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                if(!(spriteList.contains("bonarme.png"))){
                    selectedSkin.setDrawable(selectSkin3.getImage().getDrawable());
                    clickedSkin = 3;
                }
            }
        });
        
        selectSkin4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                if(!(spriteList.contains("bonerme.png"))){
                    selectedSkin.setDrawable(selectSkin4.getImage().getDrawable());
                    clickedSkin = 4;
                }
            }
        });
        
        validateButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                if(!(TFName.getText().equals("Pseudo")) && clickedSkin!=0){
                    switch(clickedSkin){
                        case 1:
                            spriteList.add("bonorme.png");
                            selectSkin1.setDisabled(true);
                            selectSkin1.getImage().setColor(0.2f, 0.2f, 0.2f, 0.9f);
                            break;
                            
                        case 2:
                            spriteList.add("bonirme.png");
                            selectSkin2.setDisabled(true);
                            selectSkin2.getImage().setColor(0.2f, 0.2f, 0.2f, 0.9f);
                            break;
                            
                        case 3:
                            spriteList.add("bonarme.png");
                            selectSkin3.setDisabled(true);
                            selectSkin3.getImage().setColor(0.2f, 0.2f, 0.2f, 0.9f);
                            break;
                            
                        case 4:
                            spriteList.add("bonerme.png");
                            selectSkin4.setDisabled(true);
                            selectSkin4.getImage().setColor(0.2f, 0.2f, 0.2f, 0.9f);
                            break;
                    }
                    clickedSkin = 0;
                    selectedSkin.setDrawable(new SpriteDrawable(new Sprite(new Texture (Gdx.files.internal("bones.png")))));
                    selectedSkin.setBounds(50, 200, 128, 256);
                    nameList.add(TFName.getText());
                    TFName.setText("Pseudo");
                    
                    if(spriteList.size()==4){
                        setTransparent(TFName);
                        setTransparent(selectSkin1);
                        setTransparent(selectSkin2);
                        setTransparent(selectSkin3);
                        setTransparent(selectSkin4);
                        setTransparent(selectedSkin);
                        setTransparent(validateButton);
                        setTransparent(entreePseudoLb);
                        setTransparent(selectedSkinLb);
                        setOpaque(selectTime);
                        setOpaque(selectTimeLb);
                        setOpaque(returnTimeButton);
                    }
                }
            }
        });
        
        returnButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                setOpaque(startButton);
                setOpaque(creditsButton);
                setOpaque(quitButton);
                setTransparent(creditsLb);
                setTransparent(returnButton);
            }
        });
        
        returnTimeButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y){
                init = true;
            }
        });
        
        //positionnement
        startButton.setPosition(350, 400);
        creditsButton.setPosition(350, 320);
        quitButton.setPosition(350, 240);
        
        TFName.setPosition(50, 600);
        entreePseudoLb.setPosition(50, 650);
        selectedSkinLb.setPosition(520, 550);
        
        creditsLb.setPosition(50, 150);
        returnButton.setPosition(700, 700);
        
        selectTime.setPosition(350,400);
        selectTimeLb.setPosition(350, 300);
        returnTimeButton.setPosition(600,100);
        
        
        //ajout des acteurs
        addActor(startButton);
        addActor(creditsButton);
        addActor(quitButton);
        addActor(selectedSkin);
        addActor(creditsLb);
        addActor(entreePseudoLb);
        addActor(selectedSkinLb);
        addActor(TFName);
        addActor(selectTime);
        addActor(selectSkin1);
        addActor(selectSkin2);
        addActor(selectSkin3);
        addActor(selectSkin4);
        addActor(selectedSkin);
        addActor(validateButton);
        addActor(returnButton);
        addActor(selectTimeLb);
        addActor(returnTimeButton);
    }
    
    private void setTransparent(TextButton actor){
        actor.setDisabled(true);
        actor.setColor(Color.CLEAR);
        actor.addAction(Actions.removeActor());
    }
    
    private void setTransparent(TextField actor){
        actor.setDisabled(true);
        actor.setColor(Color.CLEAR);
        actor.addAction(Actions.removeActor());
    }
    
    private void setTransparent(ImageButton actor){
        actor.setDisabled(true);
        actor.setColor(Color.CLEAR);
        actor.addAction(Actions.removeActor());
    }
    
    private void setTransparent(Image actor){
        actor.setColor(Color.CLEAR);
        actor.addAction(Actions.removeActor());
    }
    
    private void setTransparent(Label actor){
        actor.setColor(Color.CLEAR);
        actor.addAction(Actions.removeActor());
    }
    
    
    private void setOpaque(TextButton actor){
        actor.setDisabled(false);
        actor.setColor(Color.WHITE);
        this.addActor(actor);
    }
    
    private void setOpaque(TextField actor){
        actor.setDisabled(false);
        actor.setColor(Color.WHITE);
        this.addActor(actor);
    }
    
    private void setOpaque(ImageButton actor){
        actor.setDisabled(false);
        actor.setColor(Color.WHITE);
        this.addActor(actor);
    }
    
    private void setOpaque(Image actor){
        actor.setColor(Color.WHITE);
        this.addActor(actor);
    }
    
    private void setOpaque(Label actor){
        actor.setColor(Color.WHITE);
        this.addActor(actor);
    }
}
