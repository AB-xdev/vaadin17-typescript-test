import '@vaadin/vaadin-icons';
import '@vaadin/vaadin-button';
import '@vaadin/vaadin-combo-box';
import '@vaadin/vaadin-date-picker';
import { css, customElement, html, LitElement } from 'lit-element';
import { ButtonElement } from '@vaadin/vaadin-button';

@customElement('daterange-view')
export class DateRangeView extends LitElement {

  overlayHidden: boolean = true;

  start: Date = new Date();
  end: Date = new Date(this.start.getTime() + (1000 * 60 * 60 * 24));

  static get styles() {
    return css`
      :host {
        display: block;
        padding: 1em;
      }

      .date-range-picker-clickable {
        cursor: pointer;
      }

      .date-range-picker-button {
        margin-bottom: 0;
        border-radius: 0;
        color: var(--lumo-body-text-color);
      }

      .date-range-picker-overlay-base {
        position: relative;
      }

      .date-range-picker-overlay-layout {
        position: absolute;
        left: 0;
        right: 0;
        z-index: 1;
        background-color: var(--lumo-base-color);
        border: 1px solid var(--lumo-contrast-5pct);
        border-top: none;
      }

      .flex-container {
        display: flex;
      }

      .flex-child-autogrow {
        flex: 1 1 auto;
      }

      .flex-child-contentsize {
        flex: 0 1 auto;
      }
    `;
  }

  render() {
    return html`
      <div>
        <div>
          <vaadin-button 
            class="date-range-picker-button date-range-picker-clickable" 
            style="min-width: 20em; width: 100%"
            @click="${this.toggleOverlay}"
          >
            <iron-icon 
              slot="prefix" 
              icon=${this.overlayHidden ? "vaadin:caret-down" : "vaadin:caret-up"}
            >
            </iron-icon>
            ${this.start.toLocaleDateString()} - ${this.end.toLocaleDateString()}
          </vaadin-button>
          <div 
            class="date-range-picker-overlay-base"
            style="width: 100%;"
            ?hidden=${this.overlayHidden}
          >
            <div
              class="flex-container date-range-picker-overlay-layout"
              style="width: 100%; height: auto;"
              ?hidden=${this.overlayHidden}
            >
              Overlay
            </div>
          </div>
        </div>
      </div>
    `;
  }

  toggleOverlay(e: CustomEvent<any>) {
    (e.target as ButtonElement).disabled = true;

    this.overlayHidden = !this.overlayHidden;

    this.requestUpdate();

    (e.target as ButtonElement).disabled = false;
  }
}
