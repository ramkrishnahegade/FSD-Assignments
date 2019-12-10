import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegidterComponent } from './regidter.component';

describe('RegidterComponent', () => {
  let component: RegidterComponent;
  let fixture: ComponentFixture<RegidterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegidterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegidterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
