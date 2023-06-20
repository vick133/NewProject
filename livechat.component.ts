import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-livechat',
  templateUrl: './livechat.component.html',
  styleUrls: ['./livechat.component.css']
})
export class LivechatComponent {

  constructor(private http:HttpClient) {}

  clickedevent:Boolean=false;
  botmsg:any;
  replymsg:any;
  livechatmsg:any;
  livechatbool:Boolean=false;
  showbotbox:Boolean=false;
  touchevent(event:any)
  {
    this.clickedevent=true;
    this.botmsg=event.target.value;
    if(event.target.value=="Hi")
    {
      this.replymsg='Hi, you can ask me questions!';
    }
    else if(event.target.value=="Good morning")
    {
      this.replymsg='Good morning human!';
    }
    else if(event.target.value=="Have a query")
    {
      this.replymsg='What is your query?';
    }
    else if(event.target.value=="Thanks")
    {
      this.replymsg='You are welcome!';
    }
    else if(event.target.value=="Bye")
    {
      this.replymsg='Bye, see you!';
    }
    else if(event.target.value=="Have a great day")
    {
      this.replymsg='You too have a good day!';
    }
  }
  livechatclick()
  {
    this.livechatbool=true;
    this.livechatmsg="Connecting to support agent...";
  }
  endchat()
  {
    this.livechatbool=false;
  }
  showbot()
  {
    if(this.showbotbox==false)
    {
      this.showbotbox=true;
    }
    else
    {
      this.showbotbox=false;
    }
  }
}
