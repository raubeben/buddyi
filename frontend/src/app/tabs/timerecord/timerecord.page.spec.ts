import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TimerecordPage } from './timerecord.page';

describe('TimerecordPage', () => {
  let component: TimerecordPage;
  let fixture: ComponentFixture<TimerecordPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TimerecordPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimerecordPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
