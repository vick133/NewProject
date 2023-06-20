import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentlivechatComponent } from './agentlivechat.component';

describe('AgentlivechatComponent', () => {
  let component: AgentlivechatComponent;
  let fixture: ComponentFixture<AgentlivechatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AgentlivechatComponent]
    });
    fixture = TestBed.createComponent(AgentlivechatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
