import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NearyByShopsComponent } from './neary-by-shops.component';

describe('NearyByShopsComponent', () => {
  let component: NearyByShopsComponent;
  let fixture: ComponentFixture<NearyByShopsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NearyByShopsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NearyByShopsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
