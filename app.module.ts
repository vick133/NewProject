import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LivechatComponent } from './livechat/livechat.component';
import { LoginComponent } from './login/login.component';
import { AgentlivechatComponent } from './agentlivechat/agentlivechat.component';

@NgModule({
  declarations: [
    AppComponent,
    LivechatComponent,
    LoginComponent,
    AgentlivechatComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
