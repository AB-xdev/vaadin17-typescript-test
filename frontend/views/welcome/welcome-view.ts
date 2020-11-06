import { LitElement, html, css, customElement } from 'lit-element';

@customElement('welcome-view')
export class WelcomeView extends LitElement {
  static get styles() {
    return css`
      :host {
        display: block;
        padding: var(--lumo-space-m) var(--lumo-space-l);
      }
    `;
  }

  render() {
    return html`
      <br />
      Welcome to the Vaadin17 Typescript Demo
    `;
  }
}
